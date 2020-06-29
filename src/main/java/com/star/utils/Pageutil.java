package com.star.utils;

public class Pageutil {
    public static int PAGE_SIZE = 5;

    private int currentPage=1;

    private int totalCount;

    private int totalPage;

    private int startIndex;



    public Pageutil(int currentPage, int totalCount) {

        setCurrentPage(currentPage);

        setTotalCount(totalCount);

    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = (startIndex - 1) * PAGE_SIZE;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {

        this.currentPage = currentPage;
        setStartIndex(currentPage);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        setTotalPage(totalCount);
    }

    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 传入总记录数
     * 计算总页数
     * @param totalCount
     */
    public void setTotalPage(int totalCount) {
        if (totalCount % PAGE_SIZE == 0) {
            this.totalPage = totalCount/PAGE_SIZE;

        } else {
            this.totalPage = totalCount/PAGE_SIZE+1;
        }
    }
}
