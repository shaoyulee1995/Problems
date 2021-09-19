String findEmailDomain(String address) {
    int index = address.lastIndexOf("@");
    return address.substring(index+1);
}
