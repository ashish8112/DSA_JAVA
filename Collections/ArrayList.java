import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
       ArrayList<Integer>list = new ArrayList<>();
       
       //Add data in ArrayList
       //syntax-> ArrayList_name.add(value);
       list.add(2);
       list.add(5);
       list.add(1);
       list.add(10);
       list.add(-3);
       System.out.println(list);
       
       //Add in exisiting ArrayList 
       //syntax -> ArrayList_name.add(index,value);
       list.add(2,6);
       System.out.println("After adding 6 at index 2");
       System.out.println(list);
       
       //get the value from ArrayList
       //syntax -> ArrayList_name.get(index);
       System.out.println("Get the value from list at index 3= "+list.get(3));
       
       //Set(Modify) the value at particular index
       //syntax -> ArrayList_name.set(index,value);
       list.set(5,0);
       System.out.println(list);
       
       //Delete in list 
       //syntax -> ArrayList_name.remove(index);
       list.remove(2);
       System.out.println("Index 2 value (6) is removed "+list);
       
       //Delete in list with value 
       //syntax-> ArrayList_name.remove(Integer.valueOf(value));
       list.remove(Integer.valueOf(1));
       System.out.println("Removing value 1 from list "+list);
       
       //Delete last element in ArrayList like pop in stack
       //synatx-> ArrayList_name.removeLast();
       //or syntax -> ArrayList_name.remove(list.size()-1);
       list.removeLast();
       System.out.println("Removing last element using removeLast method = "+list);
       list.remove(list.size()-1);
       System.out.println("Removing last element by accessing last element = "+list);
       
       //Length of list 
       //syntax -> ArrayList_name.size();
       System.out.println("Length of ArrayList is = "+list.size());
       
       //Traversal using loop 
       for(int i=0;i<list.size();i++)
       System.out.print(list.get(i)+" ");
       
       //for sorting primitvie data types we were using Arrays.sort();
       //but for collection we need Collections methods 
       //syntax -> Collections.sort(list); || Ascending Order
       Collections.sort(list);
       System.out.println("\nAscending Sorted ArrayList = "+list);
       
       //Descending Sorting
       //Syntax -> Collections.sort(list,Collections.reverseOrder());
       Collections.sort(list,Collections.reverseOrder());
       System.out.println("\nDescending Sorted ArrayList = "+list);
       
       //To check that is that specific element exists or not 
       //ArrayList_name.contains(value) = returns boolean 
       System.out.println("Does 2 exists in list = "+list.contains(2));
       
       //To reverse the list only not ascending or descending
       //Syntax -> Collections.reverse(list);
       Collections.reverse(list);
       System.out.println("Reversed list = "+list);
       
       //To check list is empty or not 
       //Syntax -> list.isEmpty(); returns boolean 
       System.out.println("Is list empty ? "+list.isEmpty());
       
       //To convert list into ArrayList 
       //syntax ->int [] arr = list.toArray(new Integer[0]);
       Integer [] arr = list.toArray(new Integer[0]);
       System.out.print("Printing Array = ");
       for(int i=0;i<arr.length;i++)
       System.out.print(arr[i]+" ");
       
        System.out.print("\nUsing size = ");
       int [] arr2 = new int [list.size()];
       for(int i=0;i<arr.length;i++){
       arr2[i]=list.get(i);
       System.out.print(arr2[i]+" ");
       }
       
    }
}


//Note -> ArrayList <Integer> list = new ArrayList <>(); 
//It is nothing just a Generic class internally and list is object of that ArrayList classs 
// so why when we print list which is an object we don't get classname@hashcode (hashcode is refernce address of object)
//becuase printing of classname@hashcode is done by toString() method which every object contains and it returns classname@hashcode 
//but internally in ArrayList it is override toString() method to return data only 
//You can check bottom notes regarding toString() method in GenericMethod.java in WrapperAndGeneric Package(folder) which I have created 
