package com.cllin.cci.chap07;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Design the data structures for an online book reader system.
 */

public class Exercise07_05 extends Exercise {

    @SuppressWarnings("unused")
    private class SystemManager {
        private ArrayList<Book> mBookList;
        private ArrayList<User> mUserList;
        private boolean[] mUserIDPool;
        private int mUserIDPoolSize = 10;
        
        public SystemManager() {
            mBookList = new ArrayList<Book>();
            mUserList = new ArrayList<User>();
            mUserIDPool = new boolean[mUserIDPoolSize];
        }
        
        public boolean addBook(String name, String content) {
            return true;
        }
        
        public boolean deleteBook(String name) {
            return true;
        }
        
        public boolean addUser(String name, String content) {
            return true;
        }
        
        private int getNextAvailableID(int flag) {
            // Manage ID pools for Book and User
            return 0;
        }
        
    }
    
    private interface SuperBook {
        String getContent();
    }
    
    @SuppressWarnings("unused")
    private class Book implements SuperBook {
        private String name;
        private String content;
        public Book(String name, String content) {
            this.name = name;
            this.content = content;
        }
        
        @Override
        public String getContent() {
            return content;
        }
    }
    
    @SuppressWarnings("unused")
    private class BookOfUser extends Book {
        private int page;
        public BookOfUser(String name, String content) {
            super(name, content);
        }
        
        public int getPage() {
            return page;
        }
        
    }
    
    private interface SuperUser {
        boolean addBookToReadingList();
        boolean deleteBookFromReadingList();
        boolean updateBookToReadingList(BookOfUser book);
        BookOfUser findBookFromReadingList();
    }
    
    @SuppressWarnings("unused")
    private class User implements SuperUser {
        private int id;
        private ArrayList<BookOfUser> mReadingList;
        @Override
        public boolean addBookToReadingList() {
            return false;
        }
        @Override
        public boolean deleteBookFromReadingList() {
            return false;
        }
        @Override
        public boolean updateBookToReadingList(BookOfUser book) {
            return false;
        }
        @Override
        public BookOfUser findBookFromReadingList() {
            return null;
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        System.out.println("I've built a online book reader system, yay!");
    }

    @Override
    protected boolean test() {
        return true;
    }

}
