import java.util.*;

class SearchSuggestionSystem {
    private List<String> products;
    
    public SearchSuggestionSystem(List<String> products) {
        this.products = new ArrayList<>(products);
        Collections.sort(this.products); 
    }
    
    public List<List<String>> getSuggestions(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i).toLowerCase();
            List<String> suggestions = new ArrayList<>();
            
            for (String product : products) {
                if (suggestions.size() >= 3) break; 
                if (product.toLowerCase().startsWith(prefix)) {
                    suggestions.add(product);
                }
            }
            
            result.add(suggestions);
        }
        
        return result;
    }
}