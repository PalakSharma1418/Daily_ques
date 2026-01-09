// Last updated: 1/9/2026, 10:58:20 AM
class Solution {

    private Set<String> exactWords;
    private Map<String, String> caseInsensitive;
    private Map<String, String> vowelInsensitive;


    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactWords = new HashSet<>();
        caseInsensitive = new HashMap<>();
        vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devoweled = devowel(lower);
            vowelInsensitive.putIfAbsent(devoweled, word);
        }


        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = solveQuery(queries[i]);
        }
        return result;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }

    private String solveQuery(String query) {
        if (exactWords.contains(query)) {
            return query; // exact match
        }

        String lower = query.toLowerCase();
        if (caseInsensitive.containsKey(lower)) {
            return caseInsensitive.get(lower); // case-insensitive match
        }

        String devoweled = devowel(lower);
        if (vowelInsensitive.containsKey(devoweled)) {
            return vowelInsensitive.get(devoweled); // vowel-error match
        }

        return ""; // no match
    }
}