package lab7;
import java.util.PriorityQueue;

class Pokemon implements Comparable<Pokemon> {
		public String name;
		public int power;
		
		Pokemon(String namePokemon, int powerPokemon) {
			name = namePokemon;
			power = powerPokemon;
			
		}
		public int Power() {
			return power;
		}
		public String toString() {
			return "name: " + name + "," + "power: " + power;
		}
		
		public int compareTo(Pokemon poke2) {
			if (poke2.power > this.power) {
				System.out.println(("pokemon 2 wins");
			}
			else {
				System.out.println("Pokemon 1 wins")
			}
			
			
		}
	}

public class Pokemon {
	
	public static void main(String[] argv) {
		PriorityQueue<Pokemon> queue = new PriorityQueue<Pokemon>();
		queue.add(new Pokemon("Pikachu", 10000));
		System.out.println(one.toString())
	}
}

	
