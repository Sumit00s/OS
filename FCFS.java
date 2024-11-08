import java.util.*;

class FCFS{
    
    static boolean check_all_pro_avl(int at[],int n){
        for(int i=0; i<n; i++){
            if(at[i] != -1) return true;
        }
        
        return false;
    }
    
    static int get_sm_pro_id(int s_t,int at[],int n){
        int small_index = -1;
        for(int i=0; i<n; i++){
            //checking is available and is ready
            if(at[i] <= s_t && at[i] != -1){
                if(small_index == -1) small_index = i;
                else{
                    if(at[i]<at[small_index]){
                        small_index = i;
                    }
                }
            }
        }
        
        if(small_index == -1) return -1;
        return small_index;
        
    }
    
    public static void main(String[] args){
        
        System.out.println("Enter Number of Process : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tt[] = new int[n];
        int wt[] = new  int[n];
        
        for(int i=0; i<n; i++){
            System.out.println("Enter Process ID: ");
            pid[i] = sc.nextInt();
            
            System.out.println("Enter Arrival Time: ");
            at[i] = sc.nextInt();
            
            System.out.println("Enter Burst Time: ");
            bt[i] = sc.nextInt();
        }
        
        int system_time = 0;
        
        while(check_all_pro_avl(at,n)){
            
            int get_smallest_process_pid = get_sm_pro_id(system_time,at,n);
            
            if(get_smallest_process_pid != -1){
                system_time = system_time +  bt[get_smallest_process_pid];
                
                ct[get_smallest_process_pid] = system_time;
                
                tt[get_smallest_process_pid] = ct[get_smallest_process_pid] - at[get_smallest_process_pid];
                
                wt[get_smallest_process_pid] = tt[get_smallest_process_pid] - bt[get_smallest_process_pid];
                
                at[get_smallest_process_pid] = -1;
            }
            else{
                system_time++;
            }
        }
        
        System.out.println("PID  BT  CT  TT  WT");
        
        for(int i=0; i<n; i++){
            System.out.println(pid[i]+"   "+bt[i]+"   "+ct[i]+"   "+tt[i]+"   "+wt[i]);
        }
       
        
    }
}

