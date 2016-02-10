let ht = Hashtbl.create 400000
let heightlist = Hashtbl.create 400000 
let parse fileName =
    let f = open_in fileName in
    let (n) = Scanf.fscanf f " %d" (fun n -> (n)) in
    let buildings = ref [] in
    let heights = ref [] in
    for i = 1 to n do
        let combination = ref [] in
        for j = 1 to 4 do
            Scanf.fscanf f " %d" (fun x -> combination := x :: !combination)
        done;
     Scanf.fscanf f " %F" (fun x -> heights := x :: !heights);
     buildings := (List.rev !combination) :: !buildings
        done;
    (n, List.rev !buildings, List.rev !heights)   
;;


let rec myunionfunc a b res =
    match a with
    [] -> List.rev res
    |(h::t) -> myunionfunc t (List.tl b) ((h,List.hd b)::res)
;;



let getfirsts tup= 
    match tup with 
    (i,_) -> i;;

let getseconds tup= 
    match tup with
    (_,j) -> j;;

let getfirst tup= 
    match tup with 
    (i,_,_) -> i;;

let getsecond tup= 
    match tup with
    (_,n,_) -> n;;


let getthird tup= 
    match tup with
    (_,_,n) ->n ;;




let comp a b =  
    let af= getfirsts a in
    let bf =  getfirsts b in
    if List.nth af 1 >List.nth bf 1 then 1
            else if List.nth af 1 <List.nth bf 1 then -1
    else 0
;;

let compa a b = if a<b then -1 else 1
;;


let rec takeAllX buildings res=
    match buildings with 
        [] -> res
    | h::t -> let current=h in
    let xsw=List.nth current 0 in
    let xne=List.nth current 2 in
    (*takeAllX t (xsw::xne::res) *)
    takeAllX t (xsw::([xne]@res)) 
;;

let rec makeuniqueX allxlist res=
    match allxlist with 
    [] -> List.rev res
    |h::[] -> List.rev (h::res)
    |h::(h2::t) ->
            if h == h2 then makeuniqueX (h2::t) res
            else makeuniqueX (h2::t) (h::res)  
;;

let rec createhashtable uniqueXlist counter =
    match uniqueXlist with 
        [] -> ()
    | h::t -> let () = Hashtbl.add ht h counter in
                let () = Hashtbl.add heightlist counter 0.0
    in createhashtable t (counter+1)
;;



let rec tempfunct currentbuilding left right flag =
    if (left>=right) then flag
  else 
      let ypsos=getseconds currentbuilding in
      if (Hashtbl.find heightlist left < ypsos) then
          let () = Hashtbl.add heightlist left ypsos in
          tempfunct currentbuilding (left+1) right 1
    else
        tempfunct currentbuilding (left+1) right flag
;;


let rec dofinalwork buildings uniqueXlist counter = 
    match buildings with 
        [] ->  Printf.printf "%d\n" counter
    | h::t -> let xsw=List.nth (getfirsts h) 0 in
    let xne=List.nth (getfirsts h) 2 in
    let left=Hashtbl.find ht xsw in
    let right=Hashtbl.find ht xne in
    let resflag= tempfunct h  left right 0 in (*to teleytaio orisma einai to flag*)
    if (resflag==1) then dofinalwork t uniqueXlist (counter+1)
    else dofinalwork t uniqueXlist counter
;;



let danger = 
    let input = parse Sys.argv.(1) in
    let buildings = getsecond input in
    let allxlist = takeAllX buildings [] in 
    let allxlist = List.sort compa allxlist in    (* lista sortarismeni me oola ta xsw,xne *)
    let uniqueXlist = makeuniqueX allxlist [List.hd allxlist] in  (*list me ola ta diakrita xsw,xne *)
    let () = createhashtable uniqueXlist 1 in
    let heights= getthird input in
    let buildings = myunionfunc buildings heights [] in
    let buildings= List.sort comp buildings in
    dofinalwork buildings uniqueXlist 0

;;
