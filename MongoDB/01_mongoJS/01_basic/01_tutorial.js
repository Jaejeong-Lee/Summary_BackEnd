// 데이터베이스를 tutorial로 선정하세요.
// use tutorial

/*
 * insertOne()
 * - 하나의 문서를 컬렉션에 추가하는 명령어
 * - 형식 : db.컬렉션명.insertOne({키 : 값, ... })
 * insertMany()
 * - 여러 문서를 컬렉션에 추가하는 명령어
 * - 형식 : db.컬렉션명.insertMany([{키 : 값, ... },{키 : 값, ... },...])
 */

// users 컬렉션에 username이 smith인 문서를저장하세요.
db.users.insertOne({username: "smith"})
// users 컬렉션에 username이 jones인 문서를 저장하세요.
db.users.insertOne({username: "jones"})

// +) 여러 개의 도큐먼트를 한번에 추가
db.users.insertMany([{username: "bear"}, {username: "tiger"}])

/*
 * find() / findOne()
 * - 컬렉션에서 문서를 조회하는 명령어
 * - 형식: db.컬렉션명.find({조건},{프로젝션})
 */
// 앞에서 저장한 모든 문서를 출력하세요
db.users.find()
// id값 빼고 출력하기 위해서 : 프로젝션에 {_id : 0} 해주기
db.users.find({}, {_id: 0})

// 앞에서 저장한 문서 중 하나만 출력하세요
db.users.findOne()


//users 컬렉션에서 username이"jones"인 문서를 찾아서출력하세요
db.users.find({username: "jones"})

// users 컬렉션에서 username이 "jones" 또는 "smith"인 문서를 찾아서 출력하세요.
db.users.find({$or: [{username: "jones"}, {username: "smith"}]})

/*
 * updateOne
 * - 조건에 맞는 첫번째 문서를 수정
 * - 형식 : db.컬렉션명.updateOne( {조건} , { $set: {수정할 필드} } )
 *
 * updateMany
 * - 조건에 맞는 모든 문서를 수정
 * - 형식 : db.컬렉션명.updateMany( {조건} , { $set: {수정할 필드} } )
 */

// users 컬렉션에서 username이 smith인 문서에 country 키가 Canada 가 되도록 수정하세요.
db.users.updateOne({username:"smith"},{$set : {country:"Canada"} })

//문서가 올바르게 수정되었는지 확인하세요.
db.users.find({country : "Canada"})
db.users.find()

/*
 * replaceOne
 * - 조건에 맞는 문서를 새 문서로 교체
 * - 기존 문서의 모든 필드가 삭제되고, 새 필드로 대체됨
 */

// users 컬렉션에서 username이 smith인 문서를 {country : "Canada"}로 대체하고 확인하세요.
db.users.replaceOne( {username:"smith"} , {country : "Canada"} )
// 해석 : 기존의 username(smith)이 사라짐. 그냥 country만 있는 도큐먼트로 들어가짐.
db.users.find()

// users 컬렉션에서 username이 smith인 문서를 {country : "Canada"}로 대체하고 확인하세요.
db.users.replaceOne( {country:"Canada"} , {username:"smith", country : "Canada"} )

// users 컬렉션에서 username이 smith인 문서에서 country 키를 삭제하고, 삭제여부를 확인하세요.
db.users.updateOne({username:"smith"}, {$unset : {country : ""} } )

db.users.find()


// 데이터베이스 현재 전체 목록을 출력하세요.
//show dbs
// 사용 중인 데이터베이스의 컬렉션 목록을 출력하세요.
//show collections
// 현재 사용 중인 데이터베이스와 users 컬렉션의 상태를 출력하세요
/*
* stats
* - 데이터베이스 또는 컬렉션의 상태정보 확인
* - 문서 수, 크기, 저장 공간 등을 확인 가능하다.
* */
db.stats()
db.users.stats()

/*
* deleteOne
* - 조건에 맞는 첫번째 문서를 삭제
* - deleteMany를 사용할 때는 조건 없으면 전체가 삭제 되므로 주의 필요!
* - 형식 : db.컬렉션명.deleteOne({조건})
* */

// users 컬렉션에서 username이 smith인 문서를 삭제하고, 삭제 여부를 확인하세요.
db.users.deleteOne({username:"smith"})
db.users.find({username: "smith"})

// users 컬렉션의 모든 문서를 삭제하고, 삭제 여부를 확인하세요.
db.user.deleteMany({})
db.user.find()

/*
* drop
* - 컬렉션 자체를 삭제
* - 형식 : db.컬렉션명.drop()
* */
// users 컬렉션을 삭제하세요.
db.users.drop()
