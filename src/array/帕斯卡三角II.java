package array;
/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 */
import java.util.ArrayList;
import java.util.List;

public class 帕斯卡三角II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) 
        	return res;
        res.add(1);
        for(int i=1; i<=rowIndex; i++) { //要求出第rowIndex行，需进行rowIndex次操作
        	for(int j=res.size()-2; j>=0; j--) {
        		res.set(j+1, res.get(j)+res.get(j+1));
        	}
        	res.add(1);
        }
        return res;
    }
}
