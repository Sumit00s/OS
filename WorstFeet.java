import java.util.*;

public class WorstFeet{
    
    static int get_free_space(int current_job,int block_spaces[],int n){
        int block = -1;
        
        for(int i=0; i<n; i++){
            if(block_spaces[i] != -1){
                int frag = block_spaces[i]-current_job;
                if(frag >= 0){
                    if(block == -1) block = i;
                    else{
                        if(frag > block_spaces[block]){
                            block = i;
                        }
                    }
                }
            }
        }
        
        return block;
    }
    
    
    public static void main(String[] args){
        System.out.println("Enter the Number of Jobs: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int job_sizes[] = new int[n];
        int block_spaces[] = new int[n];
        
        for(int i=0; i<n; i++){
            System.out.println("Enter Job"+(i+1)+" :");
            job_sizes[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            System.out.println("Enter Block"+(i+1)+" Size :");
            block_spaces[i] =sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            int current_job = job_sizes[i];
            int free_space_block = get_free_space(current_job,block_spaces,n);
            
            if(free_space_block == -1){
                System.out.println("J"+(i+1)+" IS NOT GET ALLOCATED");
            }
            
            if(free_space_block != -1){
                System.out.println("J"+(i+1)+" "+current_job+" is Alocated To Block "+ block_spaces[free_space_block]);
                block_spaces[free_space_block] = -1;
            }
            
        }
        
    }
}