package CollectionFrameworks;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class weakHashMapExample {

    public static void main(String args[]) {

        //First we will know about Weak references:

        /*
 🔰 WEAKREFERENCE IN JAVA - SUMMARY

 ▪ A WeakReference allows you to refer to an object without preventing it from being garbage collected.

 ▪ If an object is ONLY referenced by a WeakReference (i.e., no strong reference exists),
    then it is considered weakly reachable and is eligible for garbage collection.

 ▪ Syntax:
     Object obj = new Object();
     WeakReference<Object> weakRef = new WeakReference<>(obj);

 ▪ If 'obj' is set to null and GC runs, then:
     weakRef.get() → returns null (because object was collected)

 ▪ weakRef.get() is used to check:
     - If the object is still alive (i.e., still has strong references)
     - Or if it has become anonymous and got collected by the garbage collector

 ▪ Use Case:
     - Caching (don't want to keep objects alive if memory is low)
     - Listener registries (avoid memory leaks)
     - Temporary or optional references

 ▪ weakRef.get() returns:
     - the object → if it’s still alive (hasn’t been GC’d)
     - null       → if it was garbage collected

 ▪ ✅ Human-friendly way to remember:
     "WeakReference is used when I don’t care much about the object.
      If it’s still there, I’ll use it — if not, no problem, let GC clean it up."

 ▪ In simple terms:
     WeakReference = “I might use it if available, but I won’t fight GC to keep it.”
     Also, it's just a way to check whether the object is still around or has become unreachable (anonymous).
         */



    // 💡 WeakHashMap Summary (Hinglish style)

// WeakHashMap ek aisi Map hai jisme keys automatically weak hoti hain.
// Tumhe manually WeakReference nahi banani padti —
// jab tum likhte ho: map.put(key1, value), to internally
// WeakHashMap khud hi key1 ko WeakReference me wrap karta hai.

// ✅ So:
// -> Agar key ka strong reference khatam ho gaya (e.g., key1 = null),
// -> Then GC us key ko hata sakta hai,
// -> Aur WeakHashMap automatically us entry ko remove kar deta hai.

// Yeh mainly memory-efficient caches ke liye use hota hai,
// jaha tumhara kehna hota hai:
// "Yeh data mere paas hai to theek, warna koi issue nahi agar chala gaya."

// 📌 Summary line:
// WeakHashMap internally keys ko weak reference me store karta hai,
// aur jab key ka strong reference chala jata hai,
// to puri entry (key + value) GC ke through remove ho jaati hai.

        

        

        //creating a weak reference:
        Integer obj = Integer.valueOf(5);
        WeakReference<Integer> weakRef = new WeakReference<>(obj); //here there is one Integer object whcih is beig pointed by obj and the info about this reference is stored inside weakRef.

        obj = null; // we made the Integer object as anonymous hence there is no one to point to it and its refernece info is stored inside weakRef object.

        Integer newObj = weakRef.get(); //using get method we can check that object is still having a strong reference or it has became anonymous. If there is stiull a string reference then it will return that refernece if not then null.


        //creating a weakHashMap:

        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        map.put(1, "ABC");
        map.put(2, "Manas");
        map.put(3, "XYZ");
        //here in the above code the keys have a strong reference and when we put them iside a weakhashmap then automatically a weakreference also points to them now jabtak keys ka strong reference hai tab tak koi dikkat nhi hai jaise hi strong reference hata waise he the complete map entry would become eligible for gc. So weakhashmap contains keys with weakreference and its just a way to check wether the key is still having a strong refernece or not.

        
    }
}
