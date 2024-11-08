import java.util.*;

class LRU{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the NO Of Frames: ");
        int no_frames = sc.nextInt();
        
        System.out.println("Enter No OF Pages: ");
        int no_pages = sc.nextInt();
        
        int pages[] = new int[no_pages];
        for(int i=0; i<no_pages; i++){
            pages[i] = sc.nextInt();
        }
        
        ArrayList<Integer> page_frame = new ArrayList<>();
        int page_fault = 0;
        int page_hit = 0;
        
        for(int i=0; i<no_pages; i++){
            int current_page = pages[i];
            if(page_frame.contains(current_page)){
                page_hit++;
                page_frame.remove((Integer) current_page);
                page_frame.add(current_page);
            }
            else{
                page_fault++;
                if(page_frame.size() == no_frames){
                    page_frame.remove(0);
                }
                page_frame.add(current_page);
            }
        }
        
        System.out.println("Page Hits: " + page_hit);
        System.out.println("Page Faults: " + page_fault);
    }
}















