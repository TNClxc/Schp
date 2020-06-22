package com.star.utils;

public class Pageutil {
    public static int PAGE_SIZE = 5;

    private int currentPage;

    private int totalCount;

    private int totalPage;

    public Pageutil(int currentPage, int totalCount) {
        setTotalPage(currentPage);
        setTotalCount(totalCount);
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {

        this.currentPage = (currentPage - 1) * PAGE_SIZE;
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

    public void setTotalPage(int totalCount) {
        if (totalCount % PAGE_SIZE == 0) {
            this.totalPage = totalPage/PAGE_SIZE;

        } else {
            this.totalPage = totalPage/PAGE_SIZE+1;
        }
    }
}
