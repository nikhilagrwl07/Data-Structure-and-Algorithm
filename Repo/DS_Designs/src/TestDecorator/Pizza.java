/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestDecorator;

import DecoratorDesignPattern.Pizza.*;

/**
 *
 * @author nikhil.agrawal
 */
public interface Pizza 
{
    public String bakePizza();

    public String serve(int customerID);

    public int cost();
}
