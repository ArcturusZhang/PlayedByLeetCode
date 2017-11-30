import java.util.Stack;

public class Solution {
    /**
     * 题目描述：<url>https://leetcode.com/problems/simplify-path/description/</url>
     * 解：
     * 利用栈。先将字符串用/分割为字符数组，即为所有的文件夹。建立一个空栈，遍历所有的文件夹名，执行如下操作：
     * 如果文件夹为"."，则跳过之，不进行任何操作。（当前文件夹）
     * 如果文件夹为".."，在栈非空时弹出栈顶元素。（上一层文件夹）
     * 其他情形（普通文件夹），将其入栈。
     * 特殊情形，可能有空文件夹名，这是由于路径中允许多个/连起来存在，例如/a///b，这样在分割字符串时可能得到空文件夹名，直接跳过即可。
     * 上面的操作进行完之后，栈中即倒序存放了绝对路径所经过的文件夹，以此弹出连接即可。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.length() == 0 || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            sb.insert(0, "/" + dir);
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../"));
        System.out.println(solution.simplifyPath("/"));
    }
}
