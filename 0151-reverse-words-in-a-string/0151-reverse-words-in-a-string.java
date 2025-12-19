/*class Solution {
    public String reverseWords(String s) {
        String [] str = s.trim().split("\\s+");
        String out ="";
        for(int i=str.length-1;i>0;i--){
            out+=str[i]+" ";

        }
        return out + str[0];
    }
}*/
class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] words=s.split("\\s+");
        int left=0; int right=words.length-1;
        while(left<right){
            String temp=words[left];
            words[left]=words[right];
            words[right]=temp;
            left++;
            right--;

        }
        return String.join(" ",words);

    }
}

       


        
