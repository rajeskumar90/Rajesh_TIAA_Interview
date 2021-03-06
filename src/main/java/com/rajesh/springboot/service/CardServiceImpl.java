package com.rajesh.springboot.service;





import java.util.Random;

import org.springframework.stereotype.Service;

@Service("cardService")
public class CardServiceImpl implements CardService {
	  private Random random = new Random(System.currentTimeMillis());

	    /**
	     * Generates a random valid credit card number.
	     *
	     * @param bin
	     *            The bank identification number, a set digits at the start of the credit card
	     *            number, used to identify the bank that is issuing the credit card.
	     * @param length
	     *            The total length (i.e. including the BIN) of the credit card number.
	     * @return
	     *            A randomly generated, valid, credit card number.
	     */
	    public String generate(String bin, int length) {

	        // The number of random digits that we need to generate is equal to the
	        // total length of the card number minus the start digits given by the
	        // user, minus the check digit at the end.
	        int randomNumberLength = length - (bin.length() + 1);

	        StringBuilder builder = new StringBuilder(bin);
	        for (int i = 0; i < randomNumberLength; i++) {
	            int digit = this.random.nextInt(10);
	            builder.append(digit);
	        }

	        // Do the Luhn algorithm to generate the check digit.
	        int checkDigit = this.getCheckDigit(builder.toString());
	        builder.append(checkDigit);

	        return builder.toString();
	    }

	    /**
	     * Generates the check digit required to make the given credit card number
	     * valid (i.e. pass the Luhn check)
	     *
	     * @param number
	     *            The credit card number for which to generate the check digit.
	     * @return The check digit required to make the given credit card number
	     *         valid.
	     */
	    private int getCheckDigit(String number) {

	        
	        int sum = 0;
	        for (int i = 0; i < number.length(); i++) {

	            // Get the digit at the current position.
	            int digit = Integer.parseInt(number.substring(i, (i + 1)));

	            if ((i % 2) == 0) {
	                digit = digit * 2;
	                if (digit > 9) {
	                    digit = (digit / 10) + (digit % 10);
	                }
	            }
	            sum += digit;
	        }

	        // The check digit is the number required to make the sum a multiple of
	        // 10.
	        int mod = sum % 10;
	        return ((mod == 0) ? 0 : 10 - mod);
	    }
}
