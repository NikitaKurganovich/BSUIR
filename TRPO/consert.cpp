#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

struct member
{
    string surname, name, lastname, country, instrument;
<<<<<<< HEAD
    int birth_year, place;
=======
    int birth_year, place;  
>>>>>>> 5762bd4a930995ca7fb23673738a16d221a5a1bd
};
    
string input_name();

const string USER_FILE = "Accounts.txt";
const string DEFAULT_USER_STRING = "admin 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 admin active";
const string MAIN_FILE = "Concert.txt";
const string DEFAULT_MAIN_FILE_STRING = "Ivanov Ivan Ivanovich 2001 Belarus piano 1";

string input_name();

int main ()
{
    /*
    char input;
    while (true)
    {
        input = getch();
        switch (input)
        {
        case '1':
            add_to_member_file();
            break;
        case '2':
            remove_from_member_file();
            break;
        case '3':
            sort_file();
            break;
        case '4':
            return;
            break;
        default:
            break;
        }
    }
    */
   cout << "Entre name: ";
   string name = input_name();
   cout << endl << name;
   system("pause");
   return 0;
}
<<<<<<< HEAD

void add_to_member_file()
{

}

void remove_from_member_file()
{

}

void sort_file()
{

}

bool check_uniqueness(member member)
{

}

string input_name()
{
    string name;
    char input;

    while(true)
    {
        input = getch();
        if(input == 13)
        {
            if(name.length() < 1) continue;
            else return name;
        }
        if(input == 8)
        {
            if(name.length() < 1 ) continue;
            else 
            {
                name.erase(name.end() - 1);
                cout << "\b \b";
            }
        }
        if((input >= 65 && input <= 90) || (input >= 97 && input <= 122))
        {
            cout << input;
            name.push_back(input);
        }
    }
}

void check_file(string FILE_NAME, string DEFAULT_STRING)
{
    ifstream file(FILE_NAME);
    if (!file.is_open())
    {
        cout << "File doesn't exist! Standart file will be created! " << endl;
        create_file(FILE_NAME, DEFAULT_STRING);
    }
}

void create_file(string FILE_NAME, string DEAFAULT_STRING)
{
    ofstream file(FILE_NAME);
    file << DEAFAULT_STRING;
}

=======

void add_to_member_file()
{

}

void remove_from_member_file()
{

}

void sort_file()
{

}

bool check_uniqueness(member member)
{

}

string input_name()
{
    string name;
    char input;

    while(true)
    {
        input = getch();
        if(input == 13)
        {
            if(name.length() < 1) continue;
            else return name;
        }
        if(input == 8)
        {
            if(name.length() < 1 ) continue;
            else 
            {
                name.erase(name.end() - 1);
                cout << "\b \b";
            }
        }
        if((input >= 65 && input <= 90) || (input >= 97 && input <= 122))
        {
            cout << input;
            name.push_back(input);
        }
    }
}
>>>>>>> 5762bd4a930995ca7fb23673738a16d221a5a1bd
