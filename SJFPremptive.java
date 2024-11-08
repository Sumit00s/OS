import java.util.*;

class SJFPremptive{
    
    static boolean check_avl(int s_t,int at[],int n){
        for(int i=0; i<n; i++){
            if(at[i] != -1) return true;
        }
        
        return false;
    }
    
    static int sm_bt_in(int s_y,int at[],int bt[],int n){
        int small_index = -1;
        for(int i=0; i<n; i++){
            if(at[i] <= s_y && at[i] != -1){
                if(small_index == -1) small_index = i;
                else{
                    if(bt[i] < bt[small_index]){
                        small_index = i;
                    }
                }
            }
        }
        
        return small_index;
    }
    
    public static void main(String[] args){
       System.out.println("Enter No of Process: ");
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       
       int pid[] = new int[n];
       int at[] = new int[n];
       int bt[] = new int[n];
       int ct[] = new int[n];
       int tt[] = new int[n];
       int wt[] = new int[n];
       
       for(int i=0; i<n; i++){
           System.out.println("Enter Process ID: ");
           pid[i] = sc.nextInt();
           
           System.out.println("Enter Arival Time: ");
           at[i] = sc.nextInt();
           
           System.out.println("Enter Burst Time: ");
           bt[i] = sc.nextInt();
       }
       
       int store_bt[] = new int[n];
       for(int i=0; i<n; i++){
           store_bt[i] = bt[i];
       }
       
       int system_time = 0;
       
       while(check_avl(system_time,at,n)){
           int get_sm_bt_in = sm_bt_in(system_time,at,bt,n);
           
           if(get_sm_bt_in != -1){
               system_time++;
               --bt[get_sm_bt_in];
               ct[get_sm_bt_in] = system_time;
               tt[get_sm_bt_in] = ct[get_sm_bt_in]-at[get_sm_bt_in];
               wt[get_sm_bt_in] = tt[get_sm_bt_in]-store_bt[get_sm_bt_in];
               if(bt[get_sm_bt_in] == 0){
                    at[get_sm_bt_in] = -1;
               }
           }
           else{
               system_time++;
           }
       }
       
       System.out.println("PID  BT  CT  TT  WT");
        
        for(int i=0; i<n; i++){
            System.out.println(pid[i]+"   "+store_bt[i]+"   "+ct[i]+"   "+tt[i]+"   "+wt[i]);
        }
    }
    
    
}
