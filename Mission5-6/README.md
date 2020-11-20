# Mission5(셸만들기) 구현내용

## 1. pwd

1. pwd      
    >현재 디렉토리 출력

       Java Shell>pwd
       c:\users\admin
       
## 2. cd

1. cd
    >admin디렉토리로 이동

        Java Shell>cd
        Java Shell>pwd
        c:\users\admin
        
2. cd /    
    >root디렉토리로 이동

        Java Shell>cd /
        Java Shell>pwd
        c:\
        
3. cd ..
    >상위디렉토리로 이동    

        Java Shell>pwd
        c:\users\admin
        Java Shell>cd ..
        Java Shell>pwd
        c:\users
        
4. cd 디렉토리명
    >해당디렉토리로 이동

        Java Shell>cd test
        Java Shell>pwd
        c:\users\admin\test
        
5. cd "디렉토리경로"
    >해당디렉토리로 이동

        Java Shell>cd "c:\users\admin\test"
        Java Shell>pwd
        c:\users\admin\test

## 3.ls
1. ls
    >해당디렉토리 리스트 출력(파일은 파일명, 디렉토리는 뒤에 '/' 추가)

        Java Shell>ls
        asdf.md
        helloworld\
        test1.txt
        test2.txt
        test55.txt
        test99.txt
        
## 4.rm
1. rm *
    >해당 디렉토리 모든 파일 삭제

        Java Shell>ls
        asdf.md
        helloworld\
        test1.txt
        test2.txt
        test55.txt
        test99.txt
        testdirectory\
        Java Shell>rm *
        Java Shell>ls
        Java Shell>
        
2. rm *.확장자명
    >*. 이후에 오는 확장자명 파일 모두 삭제

        Java Shell>ls
        asdf.md
        helloworld\
        test1.txt
        test2.txt
        test55.txt
        test99.txt
        testdirectory\
        Java Shell>rm *.txt
        Java Shell>ls
        asdf.md
        helloworld\
        testdirectory\
        
3. rm 파일명
    >파일명에 해당하는 파일 삭제

        Java Shell>ls
        test1.txt
        test2.txt
        Java Shell>rm test1.txt
        Java Shell>ls
        test2.txt
        
## 5. mkdir
1. mkdir 디렉토리명
    >현재 디렉토리에 디렉토리명에 해당하는 디렉토리 생성

        Java Shell>mkdir testdirectory
        Java Shell>ls
        test1.txt
        test2.txt
        testdirectory\
        
2. mkdir -p 상위디렉토리명/디렉토리명
    >-p 옵션 적용시 상위디렉토리까지 함께 생성

        Java Shell>mkdir -p parentdirectory/testdirectory
        Java Shell>ls
        test1.txt
        test2.txt
        parentdirectory\
        Java Shell>cd parentdirectory
        Java Shell>ls
        testdirectory\
    
## 6. touch(파일생성)
1. touch 파일명
    >현재 디렉토리에 파일명에 해당하는 파일 생성
        
        Java Shell>touch test999.txt
        Java Shell>ls
        test999.txt
        
## 7. cp
1. cp 원본파일명 "옮길디렉토리명"
    >현재 디렉토리에 있는 원본파일을 옮길디렉토리로 복사

        Java Shell>cp asdf.md "c:\users\admin\test2"
        Java Shell>cd "c:\users\admin\test2"
        Java Shell>ls
        asdf.md

2. cp 원본파일명 복사할파일명
    >현재 디렉토리에 있는 원본파일을 복사할 파일명으로 복사

        Java Shell>cp asdf.md changedname.md
        Java Shell>ls
        asdf.md
        changedname.md
        Java Shell>
        
## 8. mv
1. mv 원본파일명 "옮길디렉토리명"
    >현재 디렉토리에 있는 원본파일을 옮길디렉토리로 이동

        Java Shell>ls
        asdf.md
        test1.txt
        test2.txt
        Java Shell>mv asdf.md "c:\users\admin\test2"
        Java Shell>ls
        test1.txt
        test2.txt
        Java Shell>cd c:\users\admin\test2"
        Java Shell>ls
        asdf.md
        
2. mv 원본파일명 바꿀파일명
    >현재 디렉토리에 있는 원본파일을 바꿀파일명으로 변경

        Java Shell>ls
        asdf.md
        Java Shell>mv asdf.md changedname.md
        Java Shell>ls
        changedname.md