package CollectionFrameworks;

import java.util.concurrent.ConcurrentHashMap;

public class CocurrentHashMapExample {
    public static void main(String args[]){

        //ConcurrentMap doesnt support sorted data;

        /*
        Heirarchy:
        Map(interface) -> ConcurrentMap(interface) -> ConcurrentHashMap(Class)

        ConcurrentMap has all the methods that are in Map interface but addition to them it has 3 new methods also that are:

        Object putIfAbsent(Object key, Object value)

        boolean remove(Object key, Object value)

        boolean replace(Object key, Object oldValue, Object newValue)
         */



// ✅ ConcurrentHashMap Summary for Interviews:

// 🔹 Java 7:
// - Map is divided into 16 segments by default.
// - Each segment has its own lock (Segment-level locking).
// - Writers acquire a lock on the segment they modify.
// - Readers do not need a lock.
// - But if a writer is writing in a segment and a reader accesses the same segment, the reader has to wait (blocked).
// - Locking is also needed during:
//     • Resizing a segment
//     • Handling collisions (modifying the internal linked list)



// 🔹 Java 8:
// - Segments are removed — now it's a flat array of buckets (Node[] table).
// - Locking happens at the bucket level using synchronized blocks and CAS (Compare-And-Swap).
// - Writers acquire a lock only on the specific bucket they modify.
// - Readers do not acquire any lock — they use optimistic reading with CAS.
// - If a reader reads while a writer is writing on the same bucket:
//     • If no structural changes (e.g., simple value update), reader proceeds safely.
//     • If structural change (e.g., node insert/delete), the reader detects inconsistency and retries (not blocked).
// - Locking is still required during:
//     • Resizing the whole table (rehashing to a bigger array)
//     • Collision resolution (e.g., inserting into a linked list or treeifying)


// ⚙️ Summary:
// - Java 8 improves concurrency by using fine-grained locking and CAS.
// - Readers are never blocked; they retry instead of waiting.
// - Writers lock only what they need — either a bucket or during resizing.

        //Syntax:

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        //methods are moxstly same in Map and ConcurrentHashMap
    }
}
