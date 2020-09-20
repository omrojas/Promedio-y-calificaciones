
public class Deck {
    
    public static void main(String[] args) {
        
        Deck d = new Deck();
        String [] cartasRestantes;
        
        String[] SUITS = {
            "tréboles", "diamantes", "corazones", "picas"
        };

        String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "As"
        };
               
        // Inicializar deck con 52 cartas
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " de " + SUITS[j];
            }
        }
        
        n = d.shuffle(deck, n);
        cartasRestantes = d.head(deck);
        cartasRestantes = d.pick(cartasRestantes);
        d.hand(cartasRestantes);
    }
    
    public int shuffle (String[] deck, int n) {
            
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }  
        
        System.out.println("Se mezcló el deck.");
            
        for (int i = 0; i < n; i++) {
            System.out.println(deck[i]);
        }
        
        System.out.println("\n");
        
      return n;
    }
    
    public String[] head (String[] deck) {
        System.out.println("Primera carta del deck: " + deck[0]);
        String[] cartasRestantes = removerCarta(deck, 0);
        System.out.println("Quedan " + cartasRestantes.length + " cartas.\n");
        return cartasRestantes;
    }
    
    public String[] pick (String[] deck) {
        int max = 10; 
        int min = 2; 
        int range = max - min + 1; 
        int r = (int) (Math.random() * range) + min;
        System.out.println("Carta seleccionada al azar: " + deck[r]);
        String[] cartasRestantes = removerCarta(deck, r);
        System.out.println("Quedan " + cartasRestantes.length + " cartas.\n");
        return cartasRestantes;
    }
    
    public void hand (String[] deck) {
        int max = 10; 
        int min = 2; 
        int range = max - min + 1; 
           
        System.out.println("Mano seleccionada al azar: ");
        
        for(int i = 0; i < 5; i++) {
            int r = (int) (Math.random() * range) + min;
            System.out.println("Carta " + (i+1) + ": " + deck[r]);
            String [] cartasRestantes = removerCarta(deck, r);
        }    
        
        //System.out.println("Quedan " + cartasRestantes.length + " cartas.\n");   
    }
    
    public static String[] removerCarta(String[] deck, int index) { 
  
        if (deck == null || index < 0 || index >= deck.length) {
            return deck; 
        } 
  
        // Create another array of size one less 
        String [] anotherArray = new String[deck.length - 1]; 
  
        // Copy the elements except the index 
        // from original array to the other array 
        for (int i = 0, k = 0; i < deck.length; i++) { 
  
            // if the index is 
            // the removal element index 
            if (i == index) { 
                continue; 
            } 
  
            // if the index is not 
            // the removal element index 
            anotherArray[k++] = deck[i]; 
        } 
  
        // return the resultant array 
        return anotherArray; 
    } 
               
}