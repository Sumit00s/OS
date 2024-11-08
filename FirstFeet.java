import java.util.*;

class FirstFeet{
    
    static int get_index(int current_job,int block_sizes[],int n){
        for(int i=0; i<n; i++){
            if(block_sizes[i] != -1){
                int frag = block_sizes[i]-current_job;
                if(frag >= 0) return i;
            }
        }
        
        return -1;
    }
    
    
    public static void main(String[] args){
        System.out.println("Enter No Of JOBS: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int job_sizes[] = new int[n];
        int block_sizes[] = new int[n];
        
        for(int i=0; i<n; i++){
            System.out.println("Enter J"+(i+1)+" Size: ");
            job_sizes[i] = sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            System.out.println("Enter Block"+(i+1)+" Size: ");
            block_sizes[i] = sc.nextInt();
        }
        
        for(int i=0; i<n; i++){
            int current_job = job_sizes[i];
            int free_space_index = get_index(current_job,block_sizes,n);
            
            if(free_space_index == -1){
                System.out.println("Job J"+(i+1)+" IS NOT ALLOCATED");
            }
            
            if(free_space_index != -1){
                System.out.println("Job J"+(i+1)+" "+current_job+" is allocated to "+block_sizes[free_space_index]);
                block_sizes[free_space_index] = -1;
            }
        }
        
        
    }
}











