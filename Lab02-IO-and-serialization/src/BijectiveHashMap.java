
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BijectiveHashMap<K, V> extends HashMap<K, V> implements Serializable {

	private static final long serialVersionUID = 1197316831188352297L;
	transient private HashMap<V, K> inverseMap;
	
	public BijectiveHashMap() {
		super();
		this.inverseMap = new HashMap<V, K>();
	}
	
	public V put(K key, V value) {
		
		if(inverseMap.containsKey(value)) {
			K currKey = inverseMap.get(value);
			if(currKey.equals(key))
				return value;
			else throw new IllegalStateException("Il valore " + value + 
					" è già associato alla chiave " + currKey);
		}
		
		if(this.containsKey(key)) {
			V currValue = this.get(key);
			if(currValue.equals(value))
				return value;
			else {
				inverseMap.remove(key);
			}
		}
		
		inverseMap.put(value, key);
		return super.put(key, value);
	}
	
	public void clear() {
		inverseMap.clear();
		super.clear();
	}
	
	public K lookup(V value) {
		return inverseMap.get(value);
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		inverseMap = new HashMap<V, K>();
		
		for(Entry<K, V> e : this.entrySet()) {
			inverseMap.put(e.getValue(), e.getKey());
		}	
			
	}

	static <K, V> String mapToString(HashMap<K, V> h) {
		StringBuffer sb = new StringBuffer("{\n");
		for(Entry<K, V> e : h.entrySet()) {
			sb.append("[ " + e.getKey() + " = " + e.getValue() + "]\n");
		}
		sb.append("}\n");
		return sb.toString();
	}
	
	public String toString() {
		return BijectiveHashMap.mapToString(this) +
				BijectiveHashMap.mapToString(inverseMap);
	}
	
	public static void main(String[] args) {
		
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		BijectiveHashMap<Date, String> bhm =
			new BijectiveHashMap<Date, String>();
		Date d1 = new Date( 100000 );
		Date d2 = new Date( 200000 );
		Date d3 = new Date( 300000 );
	
		String s1 = new String( "Consiglio di dipartimento" );
		String s2 = new String( "Consiglio di facolta'" );
		String s3 = new String( "Consiglio del corso di laurea" );
	
		bhm.put( d1, s1 );
		bhm.put( d2, s2 );
		bhm.put( d3, s3 );
	
		System.out.println( bhm.toString() );
	
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream( "mappa.dat" ) );
			oos.writeObject( bhm );
			oos.flush();
	
			ois = new ObjectInputStream(
					new FileInputStream( "mappa.dat" ) );
				
			@SuppressWarnings("unchecked")
			BijectiveHashMap<Date, String> bmap =
				(BijectiveHashMap<Date, String>) ois.readObject(); 
			System.out.println( bmap.toString() );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
			} catch (IOException e) {
				System.exit(1);
			}
		}
	}
}
