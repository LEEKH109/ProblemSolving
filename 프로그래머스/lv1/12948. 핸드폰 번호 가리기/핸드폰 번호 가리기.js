function solution(phone_number) {
    let numLength = phone_number.length;
    let open = phone_number.slice(numLength-4,numLength)
    let secret = '*'.repeat(numLength-4)
    return secret+open;
}