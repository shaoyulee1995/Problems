class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myCompare = new Comparator<String>(){
            
            @Override
            public int compare(String s1, String s2){
                String[] split1 = s1.split(" ", 2),
                         split2 = s2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0)),
                        isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2){
                    int sameOrNot = split1[1].compareTo(split2[1]);
                    if(sameOrNot != 0){
                        return sameOrNot;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1? (isDigit2?0: 1): -1;
            }
        };
        Arrays.sort(logs, myCompare);
        return logs;
    }
}