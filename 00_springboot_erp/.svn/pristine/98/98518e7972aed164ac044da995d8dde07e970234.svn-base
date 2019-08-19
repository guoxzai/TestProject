package com.gxz.sys.utils.json;

import java.util.ArrayList;
import java.util.List;

public class BuilderTreeNode {

	public static List<TreeNode> builderChildersTreeNode(List<TreeNode> treeNodes,Integer topId){
		List<TreeNode> nodes = new ArrayList<>();
		
		for (TreeNode treeNode1 : treeNodes) {
			if(treeNode1.getPid() == topId) {
				nodes.add(treeNode1);
			}
			
			for (TreeNode treeNode2 : treeNodes) {
				if(treeNode1.getId() == treeNode2.getPid()) {
					treeNode1.getChildren().add(treeNode2);
				}
			}
		}
		
		return nodes;
	}
	
}
