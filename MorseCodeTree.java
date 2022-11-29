import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
    private TreeNode<String> root;
    
    /**
	 * Default constructor 
	 */
    
    public MorseCodeTree() {
    	
		root = new TreeNode<String>("");
		buildTree();
    }
    
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root=newNode;
    }
 
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }
  
    @Override
    public void insert(String code, String letter) {
		addNode(root, code , letter);
		return;
    }
    
    /**
	 * @throws UnsupportedOperationException
	 */
    
    @Override
    public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
    	
    	return null;
    }
    
    /**
	 * @throws UnsupportedOperationException
	 */
    
    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
    	
    	return null;
    }

    @Override
    public ArrayList<String> toArrayList() {
    	
        ArrayList<String> toArray=new ArrayList<>();
        LNRoutputTraversal(root, toArray);
        return toArray;
        
    }
 
    public void buildTree() {	
    	this.insert(".", "e");
    	this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
		
    }
    
    @Override
	public String fetch(String code) {
    	
		return fetchNode(root, code);
	}
    
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
    	
    	if(root!=null) {
    		
    		LNRoutputTraversal(root.leftC,list);
    		list.add(root.getData());
    		LNRoutputTraversal(root.rightC,list);
    	}
        
    }
    
    /**
	 * @param recusive add node
	 * @param recusrive for fetchnode
	 */
    
    @Override
    public String fetchNode(TreeNode<String> root, String code) {

		TreeNode<String> current = root;
		String temp;
		
		if(code.length() == 1) {
			
			if(code.equals(".")) {
				
				return current.leftC.data;
			}
			
			else {
				
				return current.rightC.data;
			}
		}

		else {
			
			if(code.charAt(0) == '.') {

				current = current.leftC;
				code = code.substring(1);
			}
			
				else {
				
				current = current.rightC;
				code = code.substring(1);
			}
			
			return fetchNode(current, code);
		}
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> add=new TreeNode<String>(letter);
		
		if(code.length()==1) {
			
			if(code.charAt(0)=='.') {
				
				if(root.leftC==null) {
					
					root.leftC=add;
				}
			}
			
			else if(code.charAt(0)=='-') {
				
				if(root.rightC==null) {
					
					root.rightC=add;
				}
			}
		}
		
		if(code.length()>1) {
			
			String hold=code.substring(1);
			
        	if(code.charAt(0)=='.') {
        		
        		addNode(root.leftC, hold,letter);
        	}
        	
        		else if(code.charAt(0)=='-') {
        		
        			addNode(root.rightC, hold,letter);
        	}
		}
	}
}