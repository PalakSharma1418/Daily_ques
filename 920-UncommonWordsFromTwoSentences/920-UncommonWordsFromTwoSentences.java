// Last updated: 8/6/2025, 4:46:37 PM
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new ArrayList();
        List<String> duplicate = new ArrayList();
        for(String s : s1.split(" ")){
            if(list.contains(s)){
                list.remove(s);
                duplicate.add(s);
            } else if(!duplicate.contains(s)){
                list.add(s);
            }
        }

        for(String s : s2.split(" ")){
            if(list.contains(s)){
                list.remove(s);
                duplicate.add(s);
            } else if(!duplicate.contains(s)){
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }
}