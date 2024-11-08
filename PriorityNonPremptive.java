import java.util.*;

class PriorityNonPremptive{
    
    static boolean check_avl(int s_y,int at[],int n){
        for(int i=0; i<n; i++){
            if(at[i] != -1) return true;
        }
        
        return false;
    }
    
    static int sm_pt_in(int s_y,int at[],int pt[],int n){
        int small_index = -1;
        for(int i=0; i<n; i++){
            if(at[i] <= s_y && at[i] != -1){
                if(small_index == -1) small_index = i;
                else{
                    if(pt[i] < pt[small_index]){
                        small_index = i;
                    }
                }
            }
        }
        
        return small_index;
    }
    
    public static void main(String[] args){
        System.out.println("Enter No of Processes: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int pt[] = new int[n];
        int ct[] = new int[n];
        int wt[] = new int[n];
        int tt[] = new int[n];
        
        for(int i=0; i<n; i++){
            System.out.println("Enter Process ID : ");
            pid[i] = sc.nextInt();
            
            System.out.println("Enter Arrival Time : ");
            at[i] = sc.nextInt();
            
            System.out.println("Enter Burst TIme : ");
            bt[i] = sc.nextInt();
            
            System.out.println("Enter Priority : ");
            pt[i] = sc.nextInt();
        }
        
        int system_time = 0;
        
        while(check_avl(system_time,at,n)){
            int get_sm_pt_in = sm_pt_in(system_time,at,pt,n);
            if(get_sm_pt_in != -1){
                system_time += bt[get_sm_pt_in];
                ct[get_sm_pt_in] = system_time;
                tt[get_sm_pt_in] = ct[get_sm_pt_in]-at[get_sm_pt_in];
                wt[get_sm_pt_in] = tt[get_sm_pt_in]-bt[get_sm_pt_in];
                at[get_sm_pt_in] = -1;
            }
            else{
                system_time++;
            }
        }
        
        
        System.out.println("PID  BT   PT   CT  TT  WT");
        
        for(int i=0; i<n; i++){
            System.out.println(pid[i]+"   "+bt[i]+"   "+pt[i]+"   "+ct[i]+"   "+tt[i]+"   "+wt[i]);
        }
        
        
    }
}





