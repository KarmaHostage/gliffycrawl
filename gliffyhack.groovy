class gliffyhack{

    static void main(String[] args) {
        (args[0].toInteger() .. args[1].toInteger()).each { download("" + it) }
    }

    public static void download(String token) {
        def file = null;
        try{
            String address = "https://www.gliffy.com/go/view/" + token + ".png"

            file = new File("${address.tokenize('/')[-1]}")
            file.withOutputStream { out ->
                out << new URL(address).openStream()
            }
        }
        catch(Exception x){
            println(token + " not found")
            if(file.exists()) file.delete()
        }
    }
}
