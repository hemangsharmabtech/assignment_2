package studyopedia;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array_to_arraylist_vice_verse {

    public static void main(String[] args) {
        // Convert array to ArrayList
        String[] array = {"Java", "Python", "C++", "JavaScript", "Ruby"};
        List<String> arrayList = arrayToArrayList(array);
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("ArrayList: " + arrayList);
        
        // Convert ArrayList to array
        String[] newArray = arrayListToArray(arrayList, String.class);
        
        System.out.println("Converted back to array: " + Arrays.toString(newArray));
    }

    // Method to convert array to ArrayList
    public static <T> List<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    // Method to convert ArrayList to array
    @SuppressWarnings("unchecked")
	public static <T> T[] arrayListToArray(List<T> arrayList, Class<T> type) {
        // Use toArray() with an array of the desired type to convert ArrayList to array
        // In this case, we use the type parameter to create a typed array
        return arrayList.toArray((T[]) java.lang.reflect.Array.newInstance(type, arrayList.size()));
    }
}


 