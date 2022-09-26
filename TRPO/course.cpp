#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstring>
#include <vector>
#include <sha256.h>
#include <iomanip>
#include <ios>

using namespace std;

struct account
{
    string login, password, access, role;
};

<<<<<<< HEAD
=======
struct member
{
    string surname, name, lastname, country, instrument;
    int birth_year, place;
};


>>>>>>> 5762bd4a930995ca7fb23673738a16d221a5a1bd
const string USER_FILE = "Accounts.txt";
const string DEFAULT_USER_STRING = "admin 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 admin active";
const string MAIN_FILE = "Concert.txt";
const string DEFAULT_MAIN_FILE_STRING = "Ivanov Ivan Ivanovich 2001 Belarus piano 1";

void create_file(string FILE_NAME, string DEAFAULT_STRING);
void check_file(string FILE_NAME, string DEFAULT_STRING);

account searching_login(string login);
string string_encription(string text);
string string_decription(string text);
string input_password();

string input_password();


void main()
{

    _getch();
    return;
}

void menu(account user)
{
    switch (hash_value(user.role))
    {
    case ct_hash("admin"):
        admin_menu();
        return;
    case ct_hash("viewer"):
        viewer_menu();
        return;
    default:
        return;
    }
}

void registration()
{
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login;
    while (true)
    {
    cout << "Entre a login: ";
    cin >> login;
    while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login ) 
            {
                system("CLS");
                cout << "This login is taken!" << endl;
            }
        }
    }
}

account authorization_and_authentication()
{ 
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login, password;
    while(true)
    {
        cout << "Entre a login: ";
        cin >> login;
        cout << "Entre a password: ";
        password = input_password();
        file.seekg(0 ,ios_base::beg);
        while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login && user.password == password) 
            {
                system("CLS");
                cout << "You entred to system!" << endl;
                return user;
            }
        }
        system("CLS");
        cout << endl << "Incorrect login or password!" << endl;
    }
<<<<<<< HEAD
=======
}

string input_password()
{
    string pass;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13)
        {
            if (pass.length() > 4) break;
            else continue;
        }
        if(ch == 8) 
        {
            if(pass.length() > 0)
            {
            cout <<"\b \b";
            pass.erase(pass.end() - 1);
            }
        }
        else 
        {
            cout << '*';
            pass.push_back(ch);
        }
    }
    return sha256(pass);
>>>>>>> 5762bd4a930995ca7fb23673738a16d221a5a1bd
}

string input_password()
{
    string pass;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13)
        {
            if (pass.length() > 4) break;
            else continue;
        }
        if(ch == 8) 
        {
            if(pass.length() > 0)
            {
            cout <<"\b \b";
            pass.erase(pass.end() - 1);
            }
        }
        else 
        {
            cout << '*';
            pass.push_back(ch);
        }
    }
    return sha256(pass);
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

constexpr size_t ct_hash_suffix(char c, size_t seed)
{
    return static_cast<size_t>(c) + 0x9e3779b9ul + (seed << 6) + (seed >> 2);
}

size_t hash_value(string const & str)
{
    size_t seed = 0;
    for(char c : str)
    {
        seed ^= ct_hash_suffix(c, seed);
    }
    return seed;
}

constexpr size_t ct_hash(char const * str, size_t seed = 0)
{
    return *str ? ct_hash(str + 1, seed ^ ct_hash_suffix(*str, seed)) : seed;
}

