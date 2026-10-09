public Member(int memberId, String name, String department) {
    this.memberId = memberId;
    this.name = name;
    this.department = department;
}

public int getMemberId() {
    return memberId;
}

public String getName() {
    return name;
}

public String getDepartment() {
    return department;
}

public void displayMember() {
    System.out.println(
        memberId + " | " + name + " | " + department
    );
}
