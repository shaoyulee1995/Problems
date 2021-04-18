class Solution {
    public boolean squareIsWhite(String coordinates) {
        return (int)coordinates.charAt(0)%2 != (int)coordinates.charAt(1)%2; 
    }
}