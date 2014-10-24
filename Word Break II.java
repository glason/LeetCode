/**
*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

*Return all such possible sentences.

*For example, given
*s = "catsanddog",
*dict = ["cat", "cats", "and", "sand", "dog"].

*A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result=new ArrayList<>();
        boolean[] character=new boolean[26];
        for(String d:dict){
            for(int i=0;i<d.length();i++){
                character[d.charAt(i)-'a']=true;
            }
        }
        for(int i=0;i<s.length();i++){
            if(!character[s.charAt(i)-'a']){
                return result;
            }
        }
        TrieNode root=new TrieNode();
        for(String d:dict){
            insert(root,d);
        }
        dfs(result,"","",s,root,root);
        return result;
    }
    private void dfs(List<String> result,String sentence,String word,String s,TrieNode cur,TrieNode root){
        if(s.length()==0){
            if(word.length()==0){
                result.add(sentence);
            }
            return;
        }
        char c=s.charAt(0);
        int pos=c-'a';
        TrieNode next=cur.next[pos];
        word+=c;
        if(next!=null){
            dfs(result,sentence,word,s.substring(1),next,root);
            if(next.isEnd){
                if(sentence.length()>0){
                    sentence+=" ";
                }
                dfs(result,sentence+word,"",s.substring(1),root,root);
            }
        }
    }
    private class TrieNode{
        private static final int R=26;
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(){
            next=new TrieNode[R];
            isEnd=false;
        }
    }
    private void insert(TrieNode root,String s){
        if(root==null){
            return;
        }
        TrieNode cur=root;
        for(int i=0;i<s.length();i++){
            int pos=s.charAt(i)-'a';
            if(cur.next[pos]==null){
                cur.next[pos]=new TrieNode();
            }
            cur=cur.next[pos];
        }
        cur.isEnd=true;
    }
}

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
         int length=s.length();
         boolean[][] dp=new boolean[length][length+1];
         for(int len=1;len<=length;len++){
             for(int start=0;start+len<=length;start++){
                 String sub=s.substring(start,start+len);
                 if(dict.contains(sub)){
                     dp[start][len]=true;
                 }else{
                     for(int k=1;k<len;k++){
                         if(dp[start][k]&&dp[start+k][len-k]){
                             dp[start][len]=true;
                             break;
                         }
                     }
                 }
             }
         }
         List<String> result=new ArrayList<>();
         dfs(result,"",0,dp,s,dict);
         return result;
     }
     private void dfs(List<String> result,String solution,int start,boolean[][] dp,String s,Set<String> dict){
         int len=s.length();
         if(start==len){
             result.add(solution.substring(1));
             return;
         }
         if(!dp[start][len-start]){
             return;
         }
         for(int l=1;start+l<=len;l++){
             if(dp[start][l]){
                 String sub=s.substring(start,start+l);
                 if(dict.contains(sub)){
                    dfs(result,solution+" "+sub,start+l,dp,s,dict);    
                 }
             }
         }
     }
}
