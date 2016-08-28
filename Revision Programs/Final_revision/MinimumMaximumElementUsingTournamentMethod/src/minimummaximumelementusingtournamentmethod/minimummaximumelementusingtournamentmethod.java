package minimummaximumelementusingtournamentmethod;

public class minimummaximumelementusingtournamentmethod {

    public static void main(String[] args) {
     int arr[] = {8000, 11, 40045, 100, -330, 3000};

        MinMax mm= get1stMax2ndMax(arr, 0, arr.length-1);
                //getMinMax(arr, 0,arr.length-1);
        
        System.out.println("min = " + mm.min + "  max = " + mm.max);


    }

    public static MinMax getMinMax(int a[], int low, int high) {
        
      //  System.out.println("low = " + low + " :: high = " + high);
        if (low == high) {
            return new MinMax(a[low], a[high]);
        }

        if (low == high - 1) {
            if (a[low] < a[high]) {
                return new MinMax(a[low], a[high]);
            } else {
                return new MinMax(a[high], a[low]);
            }
        }

        // if there are more than 2 elements

        MinMax result = new MinMax();

        int mid =((high + low)/2);

        MinMax mml = getMinMax(a, low, mid);
        MinMax mmR = getMinMax(a, mid + 1, high);

        
        
        if(mml.min<mmR.min)
        {
            result.min = mml.min;
        }
        else
        {
            result.min = mmR.min;
        }

         if(mml.max>mmR.max)
        {
            result.max = mml.max;
        }
        else
        {
            result.max = mmR.max;
        }
        
        
        
        return result;

    }
    
    
     public static MinMax get1stMax2ndMax(int a[], int low, int high ) {
        
      //  System.out.println("low = " + low + " :: high = " + high);
        if (low == high) {
            return new MinMax(a[low], a[high]);
        }

        if (low == high - 1) {
            if (a[low] < a[high]) {
                return new MinMax(a[low], a[high]);
            } else {
                return new MinMax(a[high], a[low]);
            }
        }

        // if there are more than 2 elements

        MinMax result = new MinMax();

        int mid =((high + low)/2);

        MinMax mml = get1stMax2ndMax(a, low, mid);
        MinMax mmR = get1stMax2ndMax(a, mid + 1, high);

           
        
        if (mml.max > mmR.max) {
            if(mml.min> mmR.max && mml.max > mml.min)
            {
                result.max = mml.max;
                result.min = mml.min;
            }
            else 
            {
               result.max = mml.max;
                result.min = mmR.max;
            }
        } else {
            
            if(mmR.min> mml.max && mmR.max > mmR.min)
            {
                result.max = mmR.max;
                result.min = mmR.min;
            }
            else 
            {
                result.max = mmR.max;
                result.min = mml.max;
            }
        }  
        
       
        
        return result;

    }
     
     
     
     public static MinMax get1stMin2ndMin(int a[], int low, int high) {
        
      //  System.out.println("low = " + low + " :: high = " + high);
        if (low == high) {
            return new MinMax(a[low], a[high]);
        }

        if (low == high - 1) {
            if (a[low] < a[high]) {
                return new MinMax(a[low], a[high]);
            } else {
                return new MinMax(a[high], a[low]);
            }
        }

        // if there are more than 2 elements

        MinMax result = new MinMax();

        int mid =((high + low)/2);

        MinMax mml = getMinMax(a, low, mid);
        MinMax mmR = getMinMax(a, mid + 1, high);


        if (mml.min < mmR.max) {
            result.min = mml.min;
            result.max = mmR.min;
        } else {
             result.min = mmR.min;
            result.max = mml.min;
        }
        
        return result;

    }
}

