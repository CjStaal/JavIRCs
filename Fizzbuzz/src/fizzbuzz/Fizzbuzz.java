/* 
 * Copyright (C) 2015 Charles Joseph Staal
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package fizzbuzz;

import java.io.PrintStream;

/**
 *
 * @author Charles Joseph Staal
 */
public class Fizzbuzz {

    private static final int iterations = 100;
    private static final String firstString = "FIZZ", secondString = "BUZZ";
    private static final PrintStream printer = System.out;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for(int counter = 0; counter <= iterations; counter++){
            if(counter%3 == 0) printer.print(firstString);
            if(counter%5 ==0) printer.print(secondString);
            if(counter%3 != 0 && counter%5 != 0) printer.print(counter);
            printer.print("\n");
        }
    }
    
}
