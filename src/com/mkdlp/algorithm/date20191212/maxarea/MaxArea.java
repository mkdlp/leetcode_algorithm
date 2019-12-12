package com.mkdlp.algorithm.date20191212.maxarea;

/**
 * 功能描述: 
 * 〈〉
 *
 * @author : mkdlp
 * @date : since 2019/12/12 13:10
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea_2(height));
    }

    /**
     * 功能描述:
     * 〈暴力解法〉
     *
     * @param height
     * @return : int
     * @author : mkdlp
     * @date : since 2019/12/12 13:13
     */
    public static int maxArea(int[] height) {
        int x1=0;

        int x2=0;

        int area=0;

        for(int i=0;i<height.length;i++){
            for(int j=0;j<height.length;j++){
                int max_h=height[i]>height[j]? height[j] : height[i];
                int width=(j-i)>0? (j-i) : (j-i)*-1;
                int currentArea=max_h*width;
                if(currentArea>area){
                    x1=i;
                    x2=j;
                    area=currentArea;
                }
            }
        }
        return area;
    }

    public static int maxArea_2(int[] height){
        int left=0;

        int right=height.length-1;

        int maxArea=0;

        while(left<right){
            maxArea=Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left+=1;
            }else{
                right-=1;
            }
        }
        return maxArea;
    }
}
