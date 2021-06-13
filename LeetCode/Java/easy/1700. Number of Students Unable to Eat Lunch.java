class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = {0,0};
        for(int s: students){
            count[s]++;
        }
        int j = 0;
        for(j = 0; j < sandwiches.length&& count[sandwiches[j]]>0; j++){
            count[sandwiches[j]]--;
        }
        return students.length - j;
    }
}