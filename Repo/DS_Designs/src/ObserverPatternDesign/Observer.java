/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ObserverPatternDesign;

/**
 *
 * @author nikhil.agrawal
 */
public abstract class Observer {
   protected Subject subject;
   public abstract void update();
   
}
