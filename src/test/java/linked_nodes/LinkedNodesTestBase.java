package linked_nodes;


import utils.Node;
/**
 * 
 * @ClassName LinkedNodesTestBase
 * @Description base class of LinkedNodes Test 
 * @author mark
 * @Date 2017年9月22日 上午9:21:55
 * @version 1.0.0
 */
import org.apache.log4j.Logger;

import utils.Node;

public class LinkedNodesTestBase {
    
    private static Logger logger = Logger.getLogger(LinkedNodesUtils.class);
    
    public void printNodes(Node head) {

        Node pt = head;
        while (null != pt) {
            System.out.println(pt.getValue());
            pt = pt.getNext();

        }
    }
      
    public Node initNode(String numLst) {
        Node rs = new Node();        
        if (null == numLst) {
            logger.warn("the numLst is null");
            return null;
        }
        
        String [] numStrLst = numLst.split(",", -1);
        if (null == numStrLst) {
            logger.warn("split fail!");
            return null;
        }
        Node pt = rs;
        for (String num : numStrLst) {
            pt.setNext(new Node(Integer.parseInt(num)));
            pt = pt.getNext();            
        }
        return rs.getNext();
    }

}
