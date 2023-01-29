import java.util.List;
public class LC2315countAsterisks {
        public static int countAsterisks(String s) {
//            int num = 0;
//            int flag = 0;
//            for(int i=0;i<s.length();i++){
//                if (s.charAt(i)=='|'&&flag==0) {
//                    flag=1;
//                    continue;
//                }
//                if (s.charAt(i)=='|'&& flag==1) {
//                    flag=0;
//                }
//                if(s.charAt(i)=='*'&& flag==0){
//                    num++;
//                }
//            }
//            return num;
            /**以上方法耗时太久
             *
             */
            int nums=0;
            boolean flag=true;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='|'){
                    flag=!flag;
                }//当flag处于false状态时遇见*号就不用算进去
                if(flag&&s.charAt(i)=='*')
                {
                    nums++;
                }
            }
            return nums;
        }

        public static void main(String[] args) {
            String s = "yo|uar|e**|b|e***au|tifu|l";
            System.out.println(countAsterisks(s));
        }

}
