package com.clb.share.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileOperateAction {   
    public   static   void  main(String[] args)  throws Exception  {   
        /**/ /*  ָ��Ҫ�����ļ��е�λ��,������C�̵�S�ļ����� */   
        File fileDir =   new  File( " d:\\s " );   
  
        /**/ /*  ����������ļ���λ��  */   
        File indexDir =   new  File( " d:\\index " );   
        Directory dir =  new SimpleFSDirectory(indexDir);
        Analyzer luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_4_9);
        IndexWriterConfig iwconf = new IndexWriterConfig(Version.LUCENE_4_9,luceneAnalyzer);
        IndexWriter indexWriter = new IndexWriter(dir,iwconf);   
        File[] textFiles =  fileDir.listFiles();   
        long  startTime  =   new Date().getTime();   
           
        // ����document������ȥ   
        for  ( int i=0 ; i<textFiles.length; i++ )  {   
            if  (textFiles[i].isFile()   
                    &&  textFiles[i].getName().endsWith( " .txt " ))  {   
                System.out.println(" File  "   + textFiles[i].getCanonicalPath()   
                        +   " ���ڱ�����. " );   
                String temp =  FileReaderAll(textFiles[i].getCanonicalPath(),   
                        " GBK " );   
                System.out.println(temp);   
                Document document = new  Document();   
                Field FieldPath = new  Field( "path", textFiles[i].getPath(),Field.Store.YES, Field.Index.NO);   
                Field FieldBody = new  Field( "body", temp, Field.Store.YES,Field.Index.ANALYZED);   
                document.add(FieldPath);   
                document.add(FieldBody);   
                indexWriter.addDocument(document);   
            }   
        }   
        // optimize()�����Ƕ����������Ż�   
        indexWriter.forceMerge(0);
        indexWriter.close();
           
        // ����һ��������ʱ��   
        long  endTime  =   new  Date().getTime();   
        System.out   
                .println(" �⻨����"   
                        +  (endTime  -  startTime)   
                        +   "  ���������ĵ����ӵ���������ȥ! "   
                        +  fileDir.getPath());   
    }    
  
     public   static String FileReaderAll(String FileName, String charset)   
            throws  IOException  {   
        BufferedReader reader =   new  BufferedReader( new InputStreamReader(   
                new  FileInputStream(FileName), charset));   
        String line =   new  String();   
        String temp =   new  String();   
           
        while  ((line  =  reader.readLine())  !=   null)  {   
            temp +=  line;   
        }   
        reader.close();   
        return  temp;   
    }    
}
