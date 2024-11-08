import java.util.*;

class Optimal{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter No OF Frames : ");
        int no_frames = sc.nextInt();
        
        System.out.println("Enter No Of Pages : ");
        int no_pages = sc.nextInt();
        
        int pages[] = new int[no_pages];
        for(int i=0; i<no_pages; i++){
            pages[i] = sc.nextInt();
        }
        
        ArrayList<Integer> page_stack = new ArrayList<>();
        int page_hit = 0;
        int page_fault = 0;
        
        for(int i=0; i<no_pages; i++){
            int current_page = pages[i];
            
            if(page_stack.contains(current_page)){
                page_hit++;
            }
            else{
                page_fault++;
                
                if(page_stack.size() < no_frames){
                    page_stack.add(current_page);
                }
                else{
                    int furthest = -1;
                    int index_to_replace = -1;
                    
                    for(int j=0; j<page_stack.size(); j++){
                        int nextindex = -1;
                        for(int k = i+1; k<no_pages; k++){
                            if(page_stack.get(j) == pages[k]){
                                nextindex = k;
                                break;
                            }
                        }
                        
                        if(nextindex == -1){
                            index_to_replace = j;
                            break;
                        }
                        
                        if(nextindex > furthest){
                            furthest = nextindex;
                            index_to_replace = j;
                        }
                    }
                    
                    page_stack.set(index_to_replace,current_page);
                }
                
            }
        }
        
        System.out.println("Page Hit : "+page_hit);
        System.out.println("Page Fault : "+page_fault);
    }
}














