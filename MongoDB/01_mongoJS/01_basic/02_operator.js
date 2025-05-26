// use shop

// 조건 연산자
/*
* $or
* - 여러 조건 중 하나라도 만족하는 문서를 찾을 때 사용
* */
db.member.find({
    $or: [
        {office: "seoul"},
        {age: 1}
    ]
})

/*
* $and
* - 모든 조건을 만족하는 문서를 찾을 때 사용
 */
db.member.find({
    $and : [
        {office: "busan"},
        {age: 1}
    ]
})

/*
* $in
* - 지정한 값 중 하나라도 일치하면 해당 문서를 반환
 */
db.member.find({
    office:{ $in : ["busan","seoul"]}
})

// 비교연산자
// - 숫자 또는 날짜 값을 기준으로 비교연산할 때 사용

/*
* $gt (greater than) : 값보다 큰 문서(초과)
* $lt (less than) : 값보다 작은 문서(미만)
* $gte (greater than or equal) : 값보다 크거나 같은 문서
* $lte (less than or equal) : 값보다 작거나 같은 문서
 */

db.member.find({
    age: {$gt : 50}
})

db.member.find({
    age: {$lt : 10}
})

db.member.find({
    age: {$gte:20, $lte:30 }
})

/*
* $ne
* - not equal (같지 않음) 조건
 */
db.member.find({
    office : {$ne :"busan"}
})

/*
* $exists
* - 특정 필드가 존재하는 문서만 찾기
* - true면 해당 필드가 있으면 조회
* - false면 해당 필드가 없어야 조회
 */
// unset으로 지움.(단순히 값만 지우면 null이지만 존재하는 상황됨)
// age가 1~10까지인 member들의 phone 필드 지우기
db.member.updateMany({
    age: {$gte : 1, $lte : 10}
},{
    $unset : {phone:""}
})
// $not : 부정연산자 (조건을 부정할 때 사용)
db.member.find({
    phone: { $not : {$exists : true} }
})

//db.member.find({
//    phone: { $exists : false }
//})

/*
* $regex
* 정규표현식 검색
 */
db.member.find({
    // name이 G로 시작하는 member 의미
    name: {$regex : /^G/}
})


