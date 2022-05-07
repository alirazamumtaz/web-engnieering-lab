//lsv04.c : display longlisting


#include <unistd.h>
#include <stdio.h>
#include <dirent.h>
#include <string.h>
#include<sys/stat.h>
#include <stdlib.h>
#include <errno.h>       
#include <pwd.h>
#include <grp.h>
#include <time.h> 


extern int errno;
void do_ls(char*);
int main(int argc, char* argv[]){
   if (argc == 1){
         printf("Directory listing of pwd:\n");
      do_ls(".");
   }
   else{
      int i = 0;
      while(++i < argc){
         printf("Directory listing of %s:\n\n\n", argv[i] );
	 do_ls(argv[i]);
      }
   }
   
   return 0;
}
char fileType(int mode){
	if ((mode &  0170000) == 0010000) 
			return 'p';
	else if ((mode &  0170000) == 0020000) 
			return 'c';
	else if ((mode &  0170000) == 0040000) 
			return 'd';
	else if ((mode &  0170000) == 0060000) 
			return 'b';
	else if ((mode &  0170000) == 0100000) 
			return '-';
	else if ((mode&  0170000) == 0120000) 
			return 's';
	else if ((mode &  0170000) == 0140000) 
			return '|';
}

void permission(int mode){
char str[11];
   strcpy(str, "----------");
//owner  permissions
   if((mode & 0000400) == 0000400) str[1] = 'r';
   if((mode & 0000200) == 0000200) str[2] = 'w';
   if((mode & 0000100) == 0000100) str[3] = 'x';
//group permissions
   if((mode & 0000040) == 0000040) str[4] = 'r';
   if((mode & 0000020) == 0000020) str[5] = 'w';
   if((mode & 0000010) == 0000010) str[6] = 'x';
//others  permissions
   if((mode & 0000004) == 0000004) str[7] = 'r';
   if((mode & 0000002) == 0000002) str[8] = 'w';
   if((mode & 0000001) == 0000001) str[9] = 'x';
//special  permissions
   if((mode & 0004000) == 0004000) str[2] = 's';
   if((mode & 0002000) == 0002000) str[5] = 's';
   if((mode & 0001000) == 0001000) str[8] = 't';
   str[0] = fileType(mode);
   printf("%s  ", str);
}

char* getTime(long seconds){
//char *ctime(const time_t *timep);
return ctime(&seconds);
}

char* getUserName(int userId){
	return getpwuid(userId)->pw_name;
}
char* getGroupName(int groupId){
	return getgrgid(groupId)->gr_name;
}
void  displayLonglisting(const char *filename){
	struct stat stats;
	stat(filename, &stats);
	permission(stats.st_mode);
	printf("%ld %s %s %ld %-10.10s %s \n", stats.st_nlink,getUserName(stats.st_uid), getGroupName(stats.st_gid), 					stats.st_size,getTime(stats.st_mtime),filename);
}
void do_ls(char * dir)
{
   struct dirent * entry;
   DIR * dp = opendir(dir);
   if (dp == NULL){
      fprintf(stderr, "Cannot open directory:%s\n",dir);
      exit(1);
   }
   errno = 0;
   while((entry = readdir(dp)) != NULL){
         if(entry == NULL && errno != 0){
  		perror("readdir failed");
		exit(1);
  	}
  	else{
                if(entry->d_name[0] == '.')
                    continue;
        }     	displayLonglisting(entry->d_name);//printf("%s\n",entry->d_name);
   }
   closedir(dp);
}



