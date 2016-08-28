

package sortmemorythread;

import java.util.Comparator;

/**
 *
 * @author nikhil.agrawal
 */
public class Thread{
    private int id , memblock, time;
    private char access;

    public Thread(int id, int memblock, int time , char a) {
        this.id = id;
        this.memblock = memblock;
        this.time = time;
        this.access=a;
    }

    
    public char getAccess() {
        return access;
    }

    public void setAccess(char access) {
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemblock() {
        return memblock;
    }

    public void setMemblock(int memblock) {
        this.memblock = memblock;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
    public static final Comparator<Thread> memoryBlock = new Comparator<Thread>() {

        public int compare(Thread x, Thread y) {
            if(x.getMemblock()==y.getMemblock())
            {
                return x.getTime() - y.getTime();
             }
            else
            {
              return x.getMemblock() - y.getMemblock();
            }
        }
    };

   
}
