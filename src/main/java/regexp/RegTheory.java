package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则分组机制
 */
public class RegTheory {
    
    /*
    实例分析：找出四个数字连在一起的子串
     */

    public static void main(String[] args) {
        String content = "1998年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。" +
                "2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），" +
                "代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";
        
        /* 目标：匹配所有四个数字 */
        //  1. \\d 表示一个任意的数字
        String regStr = "(\\d\\d)(\\d\\d)";
        // 2. 创建模式对象
        Pattern pattern = Pattern.compile(regStr);
        // 3. 创建一个匹配器, 按照正则的规则去匹配content
        Matcher matcher = pattern.matcher(content);
        
        // 4. 开始匹配
        /**
         * matcher.find() 完成的任务
         * 
         * 什么是分组，比如 (\d\d)(\d\d)，正则表达式中有()就表示分组，第一个()表示第1组
         * 
         * 1. 根据指定的规则，定位满足规则的子串（比如(19)98）
         * 2. 找到后，将子字符串开始的索引，记录在Matcher对象的属性中，int[] groups
         *    
         *    2.1 groups[0] = 0, 把该子字符串的结束的索引+1的值记录到groups[1] = 4 
         *        第0组就是模式串的本身
         *    2.2 记录第1组()匹配到的字符串 groups[2] = 0 groups[3] = 2
         *    2.3 记录第2组()匹配到的字符串 groups[4] = 2 groups[5] = 4
         *    2.4 如果有另外的分组，以此类推
         *    
         * 3. 同时记录oldLast 值，为找到子字符串的结束的索引 +1 的值为4，下次执行find方法时从
         *    4开始找
         * 
         * 源码：
         *     public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *     
         *     1. 根据 groups[0] 和 groups[1] 的记录的位置，从content开始截取子字符串返回
         *        就是[0,4) 
         *        
         *        如果再次执行find，仍然按照上次的分析执行
         *        
         *     2. groups[group * 2], groups[group * 2 + 1] 
         *        随着group的递增，group * 2 和 group * 2 + 1 刚好形成了连续的自然数
         *       
         * 
         */
        
        while (matcher.find()) {
            /**
             * 小结
             * 1. 如果正则表达式有()，即分组
             * 2. 取出匹配的字符串规则如下，
             * 3. group(0)表示匹配的整体字符串
             * 4. group(1)表示匹配到的第1组子串
             * 5. group(2)表示匹配到的第2组子串
             * 6. 以此类推，但是不能越界，否则会报错
             * 
             */
              
            System.out.println("找到：" + matcher.group(0));
        
            System.out.println("第1组()匹配到的值=" + matcher.group(1));
            System.out.println("第2组()匹配到的值=" + matcher.group(2));
        }
    }
    
}
