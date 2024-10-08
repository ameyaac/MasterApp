package com.example.masterapp;

public class StudentRegistration {
    int _reg_no;
    String _stu_name
            , _pwd
            , _email
            , _dob
            , _ph_no
            , _state;

    public StudentRegistration(){}

    public StudentRegistration (
            int _reg_no
            , String _stu_name
            , String _pwd
            , String _email
            , String _dob
            , String _ph_no
            , String _state
    ) {
        this._reg_no = _reg_no;
        this._stu_name = _stu_name;
        this._pwd = _pwd;
        this._email = _email;
        this._dob = _dob;
        this._ph_no = _ph_no;
        this._state = _state;
    }

    // get methods

    public int get_reg_no() {
        return _reg_no;
    }

    public String get_stu_name() {
        return _stu_name;
    }

    public String get_pwd() {
        return _pwd;
    }

    public String get_email() {
        return _email;
    }

    public String get_dob() {
        return _dob;
    }

    public String get_ph_no() {
        return _ph_no;
    }

    public String get_state() {
        return _state;
    }

    // set methods


    public void set_reg_no(int _reg_no) {
        this._reg_no = _reg_no;
    }

    public void set_stu_name(String _stu_name) {
        this._stu_name = _stu_name;
    }

    public void set_pwd(String _pwd) {
        this._pwd = _pwd;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public void set_dob(String _dob) {
        this._dob = _dob;
    }

    public void set_ph_no(String _ph_no) {
        this._ph_no = _ph_no;
    }

    public void set_state(String _state) {
        this._state = _state;
    }
}
