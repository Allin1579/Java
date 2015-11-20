package com.allin.java.algorithm;
/**
 * 排序算法
 * @author Allin
 */
public class Sort {
	
	public static void sort(int[] s){
		//算法选择
//		bubbleSort(s);
//		selectSort(s);
//		insertSort(s);
//		quickSort(s, 0, s.length - 1);
//		mergerSort(s, 0, s.length - 1);
//		radixSort(s, 3);
		shellSort(s);
//		heapSort(s);
	}
	
	/**
	 * 冒泡排序
	 * @param s
	 * @return
	 */
	public static void bubbleSort(int[] s){
		if(s == null || s.length <= 0){
			return;
		}
		
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s.length - i - 1; j++){
				if(s[j] > s[j + 1]){
					int temp = s[j];
					s[j] = s[j + 1];
					s[j + 1] = temp;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * @param s
	 * @return
	 */
	public static void selectSort(int[] s){
		if(s == null || s.length <= 0){
			return;
		}
		
		for(int i = 0; i < s.length - 1; i++){ //O = n + (n + 1) + (n + 2) + ... + 1 = O(n^2)
			for(int j = i + 1; j< s.length; j++){
				if(s[i] > s[j]){
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param s
	 * @return
	 */
	public static void insertSort(int[] s){
		if(s == null || s.length <= 0){
			return;
		}
		
		for (int i = 1; i < s.length; i++){
			if (s[i - 1] > s[i])
			{
				int temp = s[i];
				int j = i;
				while (j > 0 && s[j - 1] > temp){
					s[j] = s[j - 1];//往后挪
					j--;
				}
				s[j] = temp;
			}
         }
	}
	
	/**
	 * 快速排序
	 * @param s
	 * @return
	 */
	public static void quickSort(int[] s, int l, int r){
		if(s == null || s.length <= 0){
			return;
		}
		
		if (l < r)  
	    {  
	        int i = l, j = r, x = s[l];  //取第一个元素为基准
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
	                i++;    
	            if(i < j)   
	                s[j--] = s[i];  
	        }  
	        s[i] = x;  //i==j
	        quickSort(s, l, i - 1); // 递归调用   
	        quickSort(s, i + 1, r);  
	    }  
	}
	
	/**
	 * 归并排序
	 * @param s
	 * @return
	 */
	public static void mergerSort(int[] s, int l, int r){
		if(s == null || s.length <= 0){
			return;
		}
		
		if (l < r)
        {
			int mid = (l + r) / 2;
			//左边
			mergerSort(s, l, mid);
			//右边
			mergerSort(s, mid + 1, r);
            //左右归并
            merger(s, l, mid, r);
        }
	}
	
	/**
	 * 归并
	 * @param s
	 * @param l
	 * @param mid
	 * @param r
	 */
	private static void merger(int[] s, int l, int mid, int r){
		int[] temp = new int[r - l + 1];  
	    int i = l;// 左指针  
	    int j = mid + 1;// 右指针  
        int k = 0;  
  
        // 把较小的数先移到新数组中  
        while (i <= mid && j <= r) {  
            if (s[i] < s[j]) {  
                temp[k++] = s[i++];  
            } else {  
                temp[k++] = s[j++];  
            }  
        }  
  
        // 把左边剩余的数移入数组  
        while (i <= mid) {  
            temp[k++] = s[i++];  
        }  
  
        // 把右边边剩余的数移入数组  
        while (j <= r) {  
            temp[k++] = s[j++];  
        }  
	  
        // 把新数组中的数覆盖s数组  
	    for (int q = 0; q < temp.length; q++) {  
	        s[q + l] = temp[q];  
	    }
	}
	
	/**
	 * 基数排序
	 * @param s
	 * @return
	 */
	public static void radixSort(int[] s, int digit){
		if(s == null || s.length <= 0){
			return;
		}
		
		final int l = 0;
		final int r = s.length -1;
		final int radix = 10; // 基数
        int i = 0, j = 0;
        int[] count  = new int[radix]; // 存放各个桶的数据统计个数
        int[] bucket = new int[r - l + 1];

        // 按照从低位到高位的顺序执行排序过程
        for (int d = 1; d <= digit; d++) {

            // 置空各个桶的数据统计
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            // 统计各个桶将要装入的数据个数
            for (i = l; i <= r; i++) {
                j = getDigit(s[i], d);
                count[j]++;
            }

            // count[i]表示第i个桶的右边界索引
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 将数据依次装入桶中
            // 这里要从右向左扫描，保证排序稳定性 
            for (i = r; i >= l; i--) {
                j = getDigit(s[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5
                bucket[count[j] - 1] = s[i]; //放入对应的桶中，count[j]-1是第j个桶的右边界索引 
                count[j]--; // 对应桶的装入数据索引减一  
            }

            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
            for (i = l, j = 0; i <= r; i++, j++) {
                s[i] = bucket[j];
            }
            
        }
	}
	
	/**
	 * getDigit
	 * @param x
	 * @param d
	 * @return
	 */
	private static int getDigit(int x, int d) {
        int a[] = { 1, 1, 10, 100 }; // 本实例中的最大数是百位数，所以只要到100就可以了
        return ((x / a[d]) % 10);
    }
	
	/**
	 * 希尔排序
	 * @param s
	 * @return
	 */
	public static void shellSort(int[] s){
		if(s == null || s.length <= 0){
			return;
		}
		
		int len = s.length;
		int group, i, j, temp;
        for (group = len / 2; group > 0; group /= 2){
            for (i = group; i < len; i++){
                for (j = i - group; j >= 0; j -= group){
                    if (s[j] > s[j + group]){
                        temp = s[j];
                        s[j] = s[j + group];
                        s[j + group] = temp;
                    }
                }
            }
        }
	}
	
	/**
	 * 堆排序
	 * @param s
	 * @return
	 */
	public static void heapSort(int[] s){
		if(s == null || s.length <= 0){
			return;
		}
	}
	
	/**
	 * 检查排序是否正确
	 * @param s
	 * @return
	 */
	public static boolean isOrder(int[] s){
		for(int i = 0; i< s.length - 1; i++){
			if(s[i] > s[i+1]){
				System.out.println("排序失败");
				return false;
			}
		}
		System.out.println("排序成功");
		
		return true;
	}
	
}
